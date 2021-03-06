/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Free Software Foundation, Inc.
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
package org.datacleaner.widgets;

import javax.swing.JComponent;

import org.datacleaner.beans.transform.TokenizerTransformer;
import org.datacleaner.descriptors.Descriptors;

import junit.framework.TestCase;

public class DescriptorMenuItemTest extends TestCase {

    public void testToolTipSize() throws Exception {
        final DescriptorMenuItem menuItem =
                new DescriptorMenuItem(null, null, Descriptors.ofTransformer(TokenizerTransformer.class));

        final JComponent toolTipPanel = menuItem.createToolTipPanel();
        assertTrue(1000 > toolTipPanel.getPreferredSize().width);
        assertTrue(1000 > toolTipPanel.getPreferredSize().height);
    }
}
