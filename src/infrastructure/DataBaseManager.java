package infrastructure;

import infrastructure.lhc.Block;
import infrastructure.lhc.Experiment;
import infrastructure.lhc.IExperiment;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public enum DataBaseManager {
    instance;
    private Connection connection;


    public void main(String... args) {

        setupConnection();

        shutdown();
    }

    public void setupConnection() {
        System.out.println("--- setupConnection");

        try {
            Class.forName("org.hsqldb.jdbcDriver");
            String databaseURL = Configuration.instance.databaseDriverName + Configuration.instance.databaseFile;
            connection = DriverManager.getConnection(databaseURL, Configuration.instance.databaseUsername, Configuration.instance.databasePassword);
            System.out.println("connection : " + connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropTables() {
        System.out.println("--- dropTableExperiment");

        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("DROP TABLE experiment");
        System.out.println("sqlStringBuilder : " + sqlStringBuilder.toString());

        update(sqlStringBuilder.toString());

        System.out.println("--- dropTableExperiment");

        sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("DROP TABLE block");
        System.out.println("sqlStringBuilder : " + sqlStringBuilder.toString());

        update(sqlStringBuilder.toString());
    }

    public synchronized void update(String sqlStatement) {
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sqlStatement);

            if (result == -1) {
                System.out.println("error executing " + sqlStatement);
            }

            statement.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }



    public void createTableExperiments(){
        System.out.println("--- createTableExperiments");

        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("CREATE TABLE experiment ( ");
        sqlStringBuilder.append("uuid VARCHAR(256) NOT NULL").append(",");
        sqlStringBuilder.append("dateTimeStamp VARCHAR(256) NOT NULL").append(",");
        sqlStringBuilder.append("isHiggsFound BOOLEAN NOT NULL").append(",");
        sqlStringBuilder.append("protonId1 INTEGER NOT NULL").append(",");
        sqlStringBuilder.append("protonId2 INTEGER NOT NULL").append(",");
        sqlStringBuilder.append("checkedBefore BOOLEAN NOT NULL").append(",");
        sqlStringBuilder.append("internalBlockCount INTEGER NOT NULL").append(",");

        sqlStringBuilder.append("PRIMARY KEY (uuid)");
        sqlStringBuilder.append(" )");
        System.out.println("sqlStringBuilder : " + sqlStringBuilder.toString());

        update(sqlStringBuilder.toString());
    }

    public void createTableBlocks(){
        System.out.println("--- createTableBlocks");

        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("CREATE TABLE block ( ");
        sqlStringBuilder.append("uuid VARCHAR(256) NOT NULL").append(",");
        sqlStringBuilder.append("structure VARCHAR(256) NOT NULL").append(",");
        sqlStringBuilder.append("correspondingExperiment VARCHAR(256) NOT NULL").append(",");

        sqlStringBuilder.append("PRIMARY KEY (uuid)");
        sqlStringBuilder.append(" )");
        System.out.println("sqlStringBuilder : " + sqlStringBuilder.toString());

        update(sqlStringBuilder.toString());
    }

    public void insert(IExperiment experiment) {
        StringBuilder sqlStringStringBuilder = new StringBuilder();
        sqlStringStringBuilder.append("INSERT INTO experiment values ('" + experiment.getUuid().toString() + "','" +experiment.getDateTimeStamp() + "','" +experiment.getIsHiggsFound() + "'," +experiment.getProtonID1() + "," +experiment.getProtonID2()  + "," +experiment.getCheckedBefore() + "," +experiment.getInternalBlockCount()+")");
        update(sqlStringStringBuilder.toString());

        for (Block block:experiment.getBlocks()){
            insert(block, experiment.getUuid());
        }
    }

    public void insert(Block block, UUID uuidExperiment) {
        StringBuilder sqlStringStringBuilder = new StringBuilder();
        sqlStringStringBuilder.append("INSERT INTO block values ('" + block.getUuid().toString() + "','" + block.getStructure() + "','" + uuidExperiment.toString() + "')");
        update(sqlStringStringBuilder.toString());
    }


    public Block[] selectBlocks(UUID uuidExp){
        Block[] blocks = new Block[200000];
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM block WHERE correspondingExperiment='"+uuidExp.toString()+"'");

            int i=0;
            while (resultSet.next()) {
                blocks[i]=new Block(UUID.fromString(resultSet.getString(1)), resultSet.getString(2));
            }

            resultSet.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return blocks;
    }

    public List<IExperiment> selectExperiments(){
        List<IExperiment> experiments = new LinkedList<IExperiment>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM experiment");

            while (resultSet.next()) {
                UUID uuid= UUID.fromString(resultSet.getString(1));
                experiments.add(Experiment.ExperimentFactory.createExperimentDatabase(uuid, resultSet.getString(2),resultSet.getBoolean(3),resultSet.getInt(4),resultSet.getInt(5), resultSet.getBoolean(6),this.selectBlocks(uuid),resultSet.getInt(7)));
            }

            resultSet.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return experiments;
    }


    public void shutdown() {
        System.out.println("--- shutdown");

        try {
            Statement statement = connection.createStatement();
            statement.execute("SHUTDOWN");
            connection.close();
            System.out.println("isClosed : " + connection.isClosed());
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }
}
