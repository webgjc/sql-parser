package cn.ganjiacheng.model.lineage;

import java.util.HashSet;

/**
 * @ClassName HiveTableLineageModel
 * @description:
 * @author: again
 * @Date: 2021/3/10 8:45 下午
 */
public class TableLineageModel {

    private TableNameModel outputTable;

    /**
     * 输入的表名列表
     */
    private HashSet<TableNameModel> inputTables;

    public TableNameModel getOutputTable() {
        return outputTable;
    }

    public void setOutputTable(TableNameModel outputTable) {
        this.outputTable = outputTable;
    }

    public HashSet<TableNameModel> getInputTables() {
        return inputTables;
    }

    public void setInputTables(HashSet<TableNameModel> inputTables) {
        this.inputTables = inputTables;
    }
}
