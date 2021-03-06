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
package org.datacleaner.connection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.datacleaner.database.DatabaseDriverCatalog;
import org.datacleaner.database.DatabaseDriverDescriptor;
import org.datacleaner.util.IconUtils;
import org.datacleaner.util.PropertyUtil;
import org.datacleaner.windows.AccessDatastoreDialog;
import org.datacleaner.windows.CassandraDatastoreDialog;
import org.datacleaner.windows.CompositeDatastoreDialog;
import org.datacleaner.windows.CouchDbDatastoreDialog;
import org.datacleaner.windows.CsvDatastoreDialog;
import org.datacleaner.windows.DbaseDatastoreDialog;
import org.datacleaner.windows.DynamoDbDatastoreDialog;
import org.datacleaner.windows.ElasticSearchDatastoreDialog;
import org.datacleaner.windows.ExcelDatastoreDialog;
import org.datacleaner.windows.FixedWidthDatastoreDialog;
import org.datacleaner.windows.HBaseDatastoreDialog;
import org.datacleaner.windows.JdbcDatastoreDialog;
import org.datacleaner.windows.JsonDatastoreDialog;
import org.datacleaner.windows.KafkaDatastoreDialog;
import org.datacleaner.windows.MongoDbDatastoreDialog;
import org.datacleaner.windows.Neo4jDatastoreDialog;
import org.datacleaner.windows.SalesforceDatastoreDialog;
import org.datacleaner.windows.SasDatastoreDialog;
import org.datacleaner.windows.SugarCrmDatastoreDialog;
import org.datacleaner.windows.XmlDatastoreDialog;

public class DatastoreDescriptors {

    private static final DatastoreDescriptor CSV_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl("CSV file", "Comma-separated values (CSV) file (or file with other separators)",
                    CsvDatastore.class, CsvDatastoreDialog.class, IconUtils.CSV_IMAGEPATH, true);

    private static final DatastoreDescriptor EXCEL_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl("Excel spreadsheet",
                    "Microsoft Excel spreadsheet. Either .xls (97-2003) or .xlsx (2007+) format.", ExcelDatastore.class,
                    ExcelDatastoreDialog.class, IconUtils.EXCEL_IMAGEPATH, true);

    private static final DatastoreDescriptor ACCESS_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl("Access database", "Microsoft Access database file (.mdb).",
                    AccessDatastore.class, AccessDatastoreDialog.class, IconUtils.ACCESS_IMAGEPATH, true);

    private static final DatastoreDescriptor SAS_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl("SAS library", "A directory of SAS library files (.sas7bdat).",
                    SasDatastore.class, SasDatastoreDialog.class, IconUtils.SAS_IMAGEPATH, true);

    private static final DatastoreDescriptor DBASE_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl("DBase database", "DBase database file (.dbf)", DbaseDatastore.class,
                    DbaseDatastoreDialog.class, IconUtils.DBASE_IMAGEPATH, true);

    private static final DatastoreDescriptor FIXEDWIDTH_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl("Fixed width file",
                    "Text file with fixed width values. Each value spans a fixed amount of text characters.",
                    FixedWidthDatastore.class, FixedWidthDatastoreDialog.class, IconUtils.FIXEDWIDTH_IMAGEPATH, true);

    private static final DatastoreDescriptor XML_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl("XML file", "Extensible Markup Language file (.xml)", XmlDatastore.class,
                    XmlDatastoreDialog.class, IconUtils.XML_IMAGEPATH, true);

    private static final DatastoreDescriptor JSON_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl("JSON file", "JavaScript Object NOtation file (.json).", JsonDatastore.class,
                    JsonDatastoreDialog.class, IconUtils.JSON_IMAGEPATH, true);

    private static final DatastoreDescriptor SALESFORCE_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl("Salesforce.com", "Connect to a Salesforce.com account",
                    SalesforceDatastore.class, SalesforceDatastoreDialog.class, IconUtils.SALESFORCE_IMAGEPATH, true);

    private static final DatastoreDescriptor SUGARCRM_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl("SugarCRM", "Connect to a SugarCRM system", SugarCrmDatastore.class,
                    SugarCrmDatastoreDialog.class, IconUtils.SUGAR_CRM_IMAGEPATH, true);

    private static final DatastoreDescriptor MONGODB_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl("MongoDB database", "Connect to a MongoDB database", MongoDbDatastore.class,
                    MongoDbDatastoreDialog.class, IconUtils.MONGODB_IMAGEPATH, true);

    private static final DatastoreDescriptor COUCHDB_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl("CouchDB database", "Connect to an Apache CouchDB database",
                    CouchDbDatastore.class, CouchDbDatastoreDialog.class, IconUtils.COUCHDB_IMAGEPATH, true);
    
    private static final DatastoreDescriptor DYNAMODB_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl("AWS DynamoDB database", "Connect to an AWS DynamoDB database",
                    DynamoDbDatastore.class, DynamoDbDatastoreDialog.class, IconUtils.DYNAMODB_IMAGEPATH, true);
    
    private static final DatastoreDescriptor KAFKA_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl("Kafka stream", "Connect to an Apache Kafka stream",
                    KafkaDatastore.class, KafkaDatastoreDialog.class, IconUtils.KAFKA_IMAGEPATH, true);

    private static final DatastoreDescriptor ELASTICSEARCH_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl("ElasticSearch index", "Connect to an ElasticSearch index",
                    ElasticSearchDatastore.class, ElasticSearchDatastoreDialog.class, IconUtils.ELASTICSEARCH_IMAGEPATH,
                    true);

    private static final DatastoreDescriptor NEO4J_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl("Neo4j graph database", "Connect to a Neo4j graph database",
                    Neo4jDatastore.class, Neo4jDatastoreDialog.class, IconUtils.NEO4J_IMAGEPATH, true);

    private static final DatastoreDescriptor CASSANDRA_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl("Cassandra database", "Connect to an Apache Cassandra database",
                    CassandraDatastore.class, CassandraDatastoreDialog.class, IconUtils.CASSANDRA_IMAGEPATH, true);

    private static final DatastoreDescriptor HBASE_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl("HBase database", "Connect to an Apache HBase database", HBaseDatastore.class,
                    HBaseDatastoreDialog.class, IconUtils.HBASE_IMAGEPATH, true);

    private static final DatastoreDescriptor HIVE_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl(DatabaseDriverCatalog.DATABASE_NAME_HIVE, "Connect to an Apache Hive database",
                    JdbcDatastore.class, JdbcDatastoreDialog.class, "images/datastore-types/databases/hive.png", true);

    private static final DatastoreDescriptor MYSQL_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl(DatabaseDriverCatalog.DATABASE_NAME_MYSQL, "Connect to a MySQL database",
                    JdbcDatastore.class, JdbcDatastoreDialog.class, "images/datastore-types/databases/mysql.png", true);

    private static final DatastoreDescriptor POSTGRESQL_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl(DatabaseDriverCatalog.DATABASE_NAME_POSTGRESQL,
                    "Connect to a PostgreSQL database", JdbcDatastore.class, JdbcDatastoreDialog.class,
                    "images/datastore-types/databases/postgresql.png", true);

    private static final DatastoreDescriptor ORACLE_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl(DatabaseDriverCatalog.DATABASE_NAME_ORACLE, "Connect to a Oracle database",
                    JdbcDatastore.class, JdbcDatastoreDialog.class, "images/datastore-types/databases/oracle.png",
                    true);

    private static final DatastoreDescriptor SQLSERVER_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl(DatabaseDriverCatalog.DATABASE_NAME_MICROSOFT_SQL_SERVER_JTDS,
                    "Connect to a Microsoft SQL Server database", JdbcDatastore.class, JdbcDatastoreDialog.class,
                    "images/datastore-types/databases/microsoft.png", true);

    private static final DatastoreDescriptor COMPOSITE_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl(PropertyUtil.getProperty("datacleaner.ui.desktop.text.datastoreManagement.more.composite"), "Create a composite datastore", CompositeDatastore.class,
                    CompositeDatastoreDialog.class, IconUtils.COMPOSITE_IMAGEPATH, false);

    private static final DatastoreDescriptor OTHER_DATASTORE_DESCRIPTOR =
            new DatastoreDescriptorImpl(PropertyUtil.getProperty("datacleaner.ui.desktop.text.datastoreManagement.more.other"),
                    "Connect to other database", JdbcDatastore.class,
                    JdbcDatastoreDialog.class, IconUtils.GENERIC_DATASTORE_IMAGEPATH, false);

    private DatabaseDriverCatalog _databaseDriverCatalog;

    public DatastoreDescriptors(final DatabaseDriverCatalog databaseDriverCatalog) {
        _databaseDriverCatalog = databaseDriverCatalog;
    }

    /**
     * Returns the descriptors of datastore types available in DataCleaner.
     */
    public List<DatastoreDescriptor> getAvailableDatastoreDescriptors() {
        final List<DatastoreDescriptor> availableDatabaseDescriptors = new ArrayList<>();

        final List<DatastoreDescriptor> manualDatastoreDescriptors = getManualDatastoreDescriptors();
        availableDatabaseDescriptors.addAll(manualDatastoreDescriptors);

        final List<DatastoreDescriptor> driverBasedDatastoreDescriptors = getDriverBasedDatastoreDescriptors();
        availableDatabaseDescriptors.addAll(driverBasedDatastoreDescriptors);

        final Set<String> alreadyAddedDatabaseNames = new HashSet<>();
        for (final DatastoreDescriptor datastoreDescriptor : driverBasedDatastoreDescriptors) {
            alreadyAddedDatabaseNames.add(datastoreDescriptor.getName());
        }

        final List<DatastoreDescriptor> otherDatastoreDescriptors =
                getOtherDatastoreDescriptors(alreadyAddedDatabaseNames);
        availableDatabaseDescriptors.addAll(otherDatastoreDescriptors);

        return availableDatabaseDescriptors;
    }

    /**
     * Returns the descriptors of cloud-based datastore types available in DataCleaner.
     */
    public List<DatastoreDescriptor> getAvailableCloudBasedDatastoreDescriptors() {
        final List<DatastoreDescriptor> availableCloudBasedDatabaseDescriptors = new ArrayList<>();

        availableCloudBasedDatabaseDescriptors.add(SALESFORCE_DATASTORE_DESCRIPTOR);
        availableCloudBasedDatabaseDescriptors.add(SUGARCRM_DATASTORE_DESCRIPTOR);
        return availableCloudBasedDatabaseDescriptors;
    }

    /**
     * Returns the descriptors of database-based datastore types available in DataCleaner.
     */
    public List<DatastoreDescriptor> getAvailableDatabaseBasedDatastoreDescriptors() {
        final List<DatastoreDescriptor> availableCloudBasedDatabaseDescriptors = new ArrayList<>();

        availableCloudBasedDatabaseDescriptors.add(POSTGRESQL_DATASTORE_DESCRIPTOR);
        availableCloudBasedDatabaseDescriptors.add(SQLSERVER_DATASTORE_DESCRIPTOR);
        availableCloudBasedDatabaseDescriptors.add(ELASTICSEARCH_DATASTORE_DESCRIPTOR);
        availableCloudBasedDatabaseDescriptors.add(HBASE_DATASTORE_DESCRIPTOR);
        availableCloudBasedDatabaseDescriptors.add(HIVE_DATASTORE_DESCRIPTOR);
        availableCloudBasedDatabaseDescriptors.add(CASSANDRA_DATASTORE_DESCRIPTOR);
        availableCloudBasedDatabaseDescriptors.add(MONGODB_DATASTORE_DESCRIPTOR);
        availableCloudBasedDatabaseDescriptors.add(COUCHDB_DATASTORE_DESCRIPTOR);
        availableCloudBasedDatabaseDescriptors.add(DYNAMODB_DATASTORE_DESCRIPTOR);
        availableCloudBasedDatabaseDescriptors.add(KAFKA_DATASTORE_DESCRIPTOR);
        availableCloudBasedDatabaseDescriptors.add(NEO4J_DATASTORE_DESCRIPTOR);

        return availableCloudBasedDatabaseDescriptors;
    }

    private List<DatastoreDescriptor> getManualDatastoreDescriptors() {
        final List<DatastoreDescriptor> datastoreDescriptors = new ArrayList<>();

        datastoreDescriptors.add(CSV_DATASTORE_DESCRIPTOR);
        datastoreDescriptors.add(EXCEL_DATASTORE_DESCRIPTOR);
        datastoreDescriptors.add(ACCESS_DATASTORE_DESCRIPTOR);
        datastoreDescriptors.add(SAS_DATASTORE_DESCRIPTOR);
        datastoreDescriptors.add(DBASE_DATASTORE_DESCRIPTOR);
        datastoreDescriptors.add(FIXEDWIDTH_DATASTORE_DESCRIPTOR);
        datastoreDescriptors.add(XML_DATASTORE_DESCRIPTOR);
        datastoreDescriptors.add(JSON_DATASTORE_DESCRIPTOR);
        datastoreDescriptors.add(SALESFORCE_DATASTORE_DESCRIPTOR);
        datastoreDescriptors.add(SUGARCRM_DATASTORE_DESCRIPTOR);
        datastoreDescriptors.add(MONGODB_DATASTORE_DESCRIPTOR);
        datastoreDescriptors.add(COUCHDB_DATASTORE_DESCRIPTOR);
        datastoreDescriptors.add(DYNAMODB_DATASTORE_DESCRIPTOR);
        datastoreDescriptors.add(KAFKA_DATASTORE_DESCRIPTOR);
        datastoreDescriptors.add(ELASTICSEARCH_DATASTORE_DESCRIPTOR);
        datastoreDescriptors.add(CASSANDRA_DATASTORE_DESCRIPTOR);
        datastoreDescriptors.add(HBASE_DATASTORE_DESCRIPTOR);
        datastoreDescriptors.add(NEO4J_DATASTORE_DESCRIPTOR);

        return datastoreDescriptors;
    }

    private List<DatastoreDescriptor> getDriverBasedDatastoreDescriptors() {
        final List<DatastoreDescriptor> datastoreDescriptors = new ArrayList<>();

        if (_databaseDriverCatalog.isInstalled(DatabaseDriverCatalog.DATABASE_NAME_HIVE)) {
            datastoreDescriptors.add(HIVE_DATASTORE_DESCRIPTOR);
        }

        if (_databaseDriverCatalog.isInstalled(DatabaseDriverCatalog.DATABASE_NAME_MYSQL)) {
            datastoreDescriptors.add(MYSQL_DATASTORE_DESCRIPTOR);
        }

        if (_databaseDriverCatalog.isInstalled(DatabaseDriverCatalog.DATABASE_NAME_POSTGRESQL)) {
            datastoreDescriptors.add(POSTGRESQL_DATASTORE_DESCRIPTOR);
        }

        if (_databaseDriverCatalog.isInstalled(DatabaseDriverCatalog.DATABASE_NAME_ORACLE)) {
            datastoreDescriptors.add(ORACLE_DATASTORE_DESCRIPTOR);
        }

        if (_databaseDriverCatalog.isInstalled(DatabaseDriverCatalog.DATABASE_NAME_MICROSOFT_SQL_SERVER_JTDS)) {
            datastoreDescriptors.add(SQLSERVER_DATASTORE_DESCRIPTOR);
        }

        return datastoreDescriptors;
    }

    private List<DatastoreDescriptor> getOtherDatastoreDescriptors(final Set<String> alreadyAddedDatabaseNames) {
        final List<DatastoreDescriptor> datastoreDescriptors = new ArrayList<>();

        final List<DatabaseDriverDescriptor> databaseDrivers =
                _databaseDriverCatalog.getInstalledWorkingDatabaseDrivers();
        for (final DatabaseDriverDescriptor databaseDriver : databaseDrivers) {
            final String databaseName = databaseDriver.getDisplayName();
            if (!alreadyAddedDatabaseNames.contains(databaseName)) {
                final DatastoreDescriptor jdbcDatastoreDescriptor =
                        new DatastoreDescriptorImpl(databaseName, "Connect to " + databaseName, JdbcDatastore.class,
                                JdbcDatastoreDialog.class, databaseDriver.getIconImagePath(), false);
                datastoreDescriptors.add(jdbcDatastoreDescriptor);
            }
        }

        // custom/other jdbc connection
        if (!alreadyAddedDatabaseNames.contains(OTHER_DATASTORE_DESCRIPTOR.getName())) {
            datastoreDescriptors.add(OTHER_DATASTORE_DESCRIPTOR);
        }

        // composite datastore
        if (!alreadyAddedDatabaseNames.contains(COMPOSITE_DATASTORE_DESCRIPTOR.getName())) {
            datastoreDescriptors.add(COMPOSITE_DATASTORE_DESCRIPTOR);
        }

        return datastoreDescriptors;
    }

}
