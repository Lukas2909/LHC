package infrastructure;

import infrastructure.lhc.SearchAlgorithm;

public enum Configuration {
    instance;

    private final String aesMasterPassword="x7z99kvb6lU";
    private SearchAlgorithm detectorSearchAlgorithm = SearchAlgorithm.Native;
    public String fileSeparator = System.getProperty("file.separator");
    public String userDirectory = System.getProperty("user.dir");
    public String nameOfSubFolder = "Native" + fileSeparator + "jar";
    public String nameOfJavaArchive = "Native.jar";
    public String subFolderPathOfJavaArchive = nameOfSubFolder + fileSeparator + nameOfJavaArchive;
    public String fullPathToJavaArchive = userDirectory + subFolderPathOfJavaArchive;
    public String nameOfClass = "Native";


    public boolean LoadDataFromDatabase = false;

    public String dataDirectory = userDirectory + fileSeparator + "data" + fileSeparator;
    public String databaseFile = dataDirectory + "datastore.db";

    public String databaseDriverName = "jdbc:hsqldb:";
    public String databaseUsername = "sa";
    public String databasePassword = "";

    public SearchAlgorithm getDetectorSearchAlgorithm() {
        return detectorSearchAlgorithm;
    }


    public void setDetectorSearchAlgorithm(SearchAlgorithm detectorSearchAlgorithm) {
        this.detectorSearchAlgorithm = detectorSearchAlgorithm;
        if(detectorSearchAlgorithm==SearchAlgorithm.BoyerMoore){
            nameOfSubFolder="BoyerMoore"+fileSeparator +"jar";
            nameOfJavaArchive = "BoyerMoore.jar";
            nameOfClass = "BoyerMoore";
        }
        if(detectorSearchAlgorithm==SearchAlgorithm.KnuthMorrisPratt){
            nameOfSubFolder="KnuthMorrisPratt"+fileSeparator +"jar";
            nameOfJavaArchive = "KnuthMorrisPratt.jar";
            nameOfClass = "KnuthMorrisPratt";
        }
        if(detectorSearchAlgorithm==SearchAlgorithm.Native){
            nameOfSubFolder="Native"+fileSeparator +"jar";
            nameOfJavaArchive = "Native.jar";
            nameOfClass = "Native";
        }
    }

    public String getAesMasterPassword() {
        return aesMasterPassword;
    }


}
