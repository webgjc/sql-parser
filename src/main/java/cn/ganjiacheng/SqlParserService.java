package cn.ganjiacheng;

import cn.ganjiacheng.enums.SqlTypeEnum;
import cn.ganjiacheng.model.lineage.FieldLineageModel;
import cn.ganjiacheng.model.lineage.TableLineageModel;
import cn.ganjiacheng.model.metadata.TableMetadataModel;

import java.util.List;

/**
 * @ClassName SqlParserService
 * @description: sql解析接口
 * @author: again
 * @Date: 2021/3/10 4:05 下午
 */
public interface SqlParserService {
    /**
     * 获取sql类型
     */
    SqlTypeEnum parseSqlType(String sql);

    /**
     * 获取创表语句元数据
     */
    TableMetadataModel parseSqlMetadata(String sql);

    /**
     * sql格式化
     */
    String parseSqlFormatter(String sql);

    /**
     * sql解析表元数据
     */
    TableLineageModel parseSqlTableLineage(String sql);

    /**
     * sql解析字段元数据
     */
    List<FieldLineageModel> parseSqlFieldLineage(String sql);
}
