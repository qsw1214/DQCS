/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Neopost - Customer Information Management
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.datacleaner.monitor.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.datacleaner.api.AnalyzerResult;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Identifies a metric of interest.
 * 标识兴趣指标。
 */
public class MetricIdentifier implements Serializable, Comparable<MetricIdentifier> {

    private static final long serialVersionUID = 1L;

    private String _analyzerDescriptorName;
    private String _analyzerName;
    private String _analyzerInputName;
    private String _metricDescriptorName;
    private String _metricDisplayName;
    private String _metricColor;
    private String _paramQueryString;
    private String _paramColumnName;
    private boolean _parameterizedByQueryString;
    private boolean _parameterizedByColumnName;
    private String _formula;
    private List<MetricIdentifier> _children;

    // full constructor that specifies every field in one go.
    public MetricIdentifier(String metricDisplayName, String analyzerDescriptorName, String analyzerName,
            String analyzerInputName, String metricDescriptorName, String paramQueryString, String paramColumnName,
            boolean parameterizedByQueryString, boolean parameterizedByColumnName) {
        _metricDisplayName = metricDisplayName;
        _analyzerDescriptorName = analyzerDescriptorName;
        _analyzerName = analyzerName;
        _analyzerInputName = analyzerInputName;
        _metricDescriptorName = metricDescriptorName;
        _paramQueryString = paramQueryString;
        _paramColumnName = paramColumnName;
        _parameterizedByQueryString = parameterizedByQueryString;
        _parameterizedByColumnName = parameterizedByColumnName;
    }

    public MetricIdentifier(String metricDisplayName, String formula, List<MetricIdentifier> children) {
        _metricDisplayName = metricDisplayName;
        _formula = formula;
        _children = children;
    }

    // no-arg constructor used by GWT
    public MetricIdentifier() {
    }

    @JsonIgnore
    public boolean isFormulaBased() {
        return _formula != null;
    }

    @JsonIgnore
    public String getId() {
        if (isFormulaBased()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (MetricIdentifier child : getChildren()) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(child.getId());
            }
            sb.append("]");
            return _formula + "_" + sb;
        }
        String ID = _analyzerDescriptorName + _analyzerInputName + _analyzerName + _metricDescriptorName
                + _paramColumnName + _paramQueryString;
        return ID.replaceAll("'", "");
    }

    public String getAnalyzerDescriptorName() {
        return _analyzerDescriptorName;
    }

    public void setAnalyzerDescriptorName(String analyzerDescriptorName) {
        _analyzerDescriptorName = analyzerDescriptorName;
    }

    public String getAnalyzerName() {
        return _analyzerName;
    }

    public void setAnalyzerName(String analyzerName) {
        _analyzerName = analyzerName;
    }

    public String getMetricDescriptorName() {
        return _metricDescriptorName;
    }

    public void setMetricDescriptorName(String metricDescriptorName) {
        _metricDescriptorName = metricDescriptorName;
    }

    public String getAnalyzerInputName() {
        return _analyzerInputName;
    }

    public void setAnalyzerInputName(String analyzerInputName) {
        _analyzerInputName = analyzerInputName;
    }

    public void setParamColumnName(String paramColumnName) {
        _paramColumnName = paramColumnName;
    }

    public String getParamColumnName() {
        return _paramColumnName;
    }

    public void setParamQueryString(String paramQueryString) {
        _paramQueryString = paramQueryString;
    }

    public String getParamQueryString() {
        return _paramQueryString;
    }

    public boolean isParameterizedByColumnName() {
        return _parameterizedByColumnName;
    }

    public void setParameterizedByColumnName(boolean parameterizedByColumnName) {
        _parameterizedByColumnName = parameterizedByColumnName;
    }

    public boolean isParameterizedByQueryString() {
        return _parameterizedByQueryString;
    }

    public void setParameterizedByQueryString(boolean parameterizedByQueryString) {
        _parameterizedByQueryString = parameterizedByQueryString;
    }
    
    public String getMetricDisplayName() {
        return _metricDisplayName;
    }

    public void setMetricDisplayName(String metricDisplayName) {
        _metricDisplayName = metricDisplayName;
    }

    @JsonIgnore
    public String getDisplayName() {
        if (_metricDisplayName == null || "".equals(_metricDisplayName)) {
            if (isFormulaBased()) {
                return _formula;
            }
            if (_paramColumnName != null) {
                return _metricDescriptorName + " (" + _paramColumnName + ")";
            }
            if (_paramQueryString != null) {
                return _metricDescriptorName + ": " + _paramQueryString;
            }
            if (_analyzerInputName != null) {
                return _metricDescriptorName + " (" + _analyzerInputName + ")";
            }
            return _metricDescriptorName;
        }
        return _metricDisplayName;
    }

    /**
     * Determines if the displayname has been set by the user or if it is
     * automatically generated based on the metric's descriptor.
     * 
     * @return
     */
    @JsonIgnore
    public boolean isDisplayNameSet() {
        return _metricDisplayName != null;
    }

    public void setMetricColor(String metricColor) {
        _metricColor = metricColor;
    }

    public String getMetricColor() {
        return _metricColor;
    }

    /**
     * Creates a copy of this {@link MetricIdentifier}.
     * 
     * @return
     */
    public MetricIdentifier copy() {
        if (isFormulaBased()) {
            final List<MetricIdentifier> children = new ArrayList<MetricIdentifier>();
            for (MetricIdentifier child : getChildren()) {
                MetricIdentifier childCopy = child.copy();
                children.add(childCopy);
            }
            final MetricIdentifier metricIdentifier = new MetricIdentifier(_metricDisplayName, _formula, children);
            return metricIdentifier;
        }

        final MetricIdentifier metricIdentifier = new MetricIdentifier(_metricDisplayName, _analyzerDescriptorName,
                _analyzerName, _analyzerInputName, _metricDescriptorName, _paramQueryString, _paramColumnName,
                _parameterizedByQueryString, _parameterizedByColumnName);
        return metricIdentifier;
    }

    public void setFormula(String formula) {
        _formula = formula;
    }

    public String getFormula() {
        return _formula;
    }

    public void setChildren(List<MetricIdentifier> children) {
        _children = children;
    }

    public List<MetricIdentifier> getChildren() {
        return _children;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((_analyzerDescriptorName == null) ? 0 : _analyzerDescriptorName.hashCode());
        result = prime * result + ((_analyzerInputName == null) ? 0 : _analyzerInputName.hashCode());
        result = prime * result + ((_analyzerName == null) ? 0 : _analyzerName.hashCode());
        result = prime * result + ((_children == null) ? 0 : _children.hashCode());
        result = prime * result + ((_formula == null) ? 0 : _formula.hashCode());
        result = prime * result + ((_metricColor == null) ? 0 : _metricColor.hashCode());
        result = prime * result + ((_metricDescriptorName == null) ? 0 : _metricDescriptorName.hashCode());
        result = prime * result + ((_metricDisplayName == null) ? 0 : _metricDisplayName.hashCode());
        result = prime * result + ((_paramColumnName == null) ? 0 : _paramColumnName.hashCode());
        result = prime * result + ((_paramQueryString == null) ? 0 : _paramQueryString.hashCode());
        result = prime * result + (_parameterizedByColumnName ? 1231 : 1237);
        result = prime * result + (_parameterizedByQueryString ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MetricIdentifier other = (MetricIdentifier) obj;
        if (_analyzerDescriptorName == null) {
            if (other._analyzerDescriptorName != null)
                return false;
        } else if (!_analyzerDescriptorName.equals(other._analyzerDescriptorName))
            return false;
        if (_analyzerInputName == null) {
            if (other._analyzerInputName != null)
                return false;
        } else if (!_analyzerInputName.equals(other._analyzerInputName))
            return false;
        if (_analyzerName == null) {
            if (other._analyzerName != null)
                return false;
        } else if (!_analyzerName.equals(other._analyzerName))
            return false;
        if (_children == null) {
            if (other._children != null)
                return false;
        } else if (!_children.equals(other._children))
            return false;
        if (_formula == null) {
            if (other._formula != null)
                return false;
        } else if (!_formula.equals(other._formula))
            return false;
        if (_metricColor == null) {
            if (other._metricColor != null)
                return false;
        } else if (!_metricColor.equals(other._metricColor))
            return false;
        if (_metricDescriptorName == null) {
            if (other._metricDescriptorName != null)
                return false;
        } else if (!_metricDescriptorName.equals(other._metricDescriptorName))
            return false;
        if (_metricDisplayName == null) {
            if (other._metricDisplayName != null)
                return false;
        } else if (!_metricDisplayName.equals(other._metricDisplayName))
            return false;
        if (_paramColumnName == null) {
            if (other._paramColumnName != null)
                return false;
        } else if (!_paramColumnName.equals(other._paramColumnName))
            return false;
        if (_paramQueryString == null) {
            if (other._paramQueryString != null)
                return false;
        } else if (!_paramQueryString.equals(other._paramQueryString))
            return false;
        if (_parameterizedByColumnName != other._parameterizedByColumnName)
            return false;
        if (_parameterizedByQueryString != other._parameterizedByQueryString)
            return false;
        return true;
    }

    /**
     * Determines if two {@link MetricIdentifier}s match if ignoring parameter
     * values as well as the details that can be customized/parameterized by the
     * user:
     * 
     * <ul>
     * <li>Display name</li>
     * <li>Color</li>
     * <li>Query parameter</li>
     * <li>Column parameter</li>
     * </ul>
     * 
     * In other words - determines if the two {@link MetricIdentifier}s
     * reference the same metric in the same {@link AnalyzerResult}.
     * 
     * @param other
     * @return
     */
    public boolean equalsIgnoreParameterValues(MetricIdentifier other) {
        if (this == other)
            return true;
        if (other == null)
            return false;
        if (_analyzerDescriptorName == null) {
            if (other._analyzerDescriptorName != null)
                return false;
        } else if (!_analyzerDescriptorName.equals(other._analyzerDescriptorName))
            return false;
        if (_analyzerInputName == null) {
            if (other._analyzerInputName != null)
                return false;
        } else if (!_analyzerInputName.equals(other._analyzerInputName))
            return false;
        if (_analyzerName == null) {
            if (other._analyzerName != null)
                return false;
        } else if (!_analyzerName.equals(other._analyzerName))
            return false;
        if (_children == null) {
            if (other._children != null)
                return false;
        } else if (!_children.equals(other._children))
            return false;
        if (_formula == null) {
            if (other._formula != null)
                return false;
        } else if (!_formula.equals(other._formula))
            return false;

        if (_metricDescriptorName == null) {
            if (other._metricDescriptorName != null)
                return false;
        } else if (!_metricDescriptorName.equals(other._metricDescriptorName))
            return false;
        if (_parameterizedByColumnName != other._parameterizedByColumnName)
            return false;
        if (_parameterizedByQueryString != other._parameterizedByQueryString)
            return false;
        return true;
    }

    /**
     * Determines if two {@link MetricIdentifier}s match if ignoring the details
     * that can be customized/parameterized by the user:
     * 
     * <ul>
     * <li>Display name</li>
     * <li>Color</li>
     * </ul>
     * 
     * @param other
     * @return
     */
    public boolean equalsIgnoreCustomizedDetails(MetricIdentifier other) {
        if (!equalsIgnoreParameterValues(other)) {
            return false;
        }

        if (_paramColumnName == null) {
            if (other._paramColumnName != null)
                return false;
        } else if (!_paramColumnName.equals(other._paramColumnName))
            return false;
        if (_paramQueryString == null) {
            if (other._paramQueryString != null)
                return false;
        } else if (!_paramQueryString.equals(other._paramQueryString))
            return false;

        return true;
    }

    @Override
    public String toString() {
        if (isFormulaBased()) {
            return "MetricIdentifier[formula=" + _formula + "]";
        }
        return "MetricIdentifier[analyzerInputName=" + _analyzerInputName + ",metricDescriptorName="
                + _metricDescriptorName + (_paramColumnName != null ? ",paramColumnName=" + _paramColumnName : "")
                + (_paramQueryString != null ? ",paramQueryString=" + _paramQueryString : "") + "]";
    }

    @Override
    public int compareTo(MetricIdentifier other) {
        if (this == other) {
            return 0;
        }
        return getId().compareTo(other.getId());
    }
}
