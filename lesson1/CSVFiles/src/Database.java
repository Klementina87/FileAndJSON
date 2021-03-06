import java.util.Arrays;

public class Database {
    private String[] colNames;
    private int numRows;
    private String[][] data;

    public String[] getColNames() {
        return colNames;
    }

    public void setColNames(String[] colNames) {
        this.colNames = colNames;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public Database(String contents) {
        String[] rows = contents.split("\n");
        this.colNames = rows[0].split(",");
        this.numRows = rows.length - 1;
        for (int i = 1; i <= numRows-1 ; i++) {
            String[] cols = rows[i].split(",");
            for (int j = 0; j < colNames.length; j++) {
                this.data[i-1][j] = cols[j];
            }
        }

/* TODO 
This constructor should take the contents of a CSV file and initialize the memember variables of the Database class.
*/
    }

    public String getValue(String columnName,int row){
        String result = "";
        for (int i = 0; i < this.data[0].length; i++) {
            if (this.data[i].equals(columnName))
                for (int j = 0; j <= row; j++) {
                    result = this.data[i][j];
                }
        }

        return result;
 /* TODO
This method should return the data contained on row "row" and the column matching  @columname
                */
    }


}


