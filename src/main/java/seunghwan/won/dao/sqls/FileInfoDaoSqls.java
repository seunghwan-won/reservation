package seunghwan.won.dao.sqls;

public class FileInfoDaoSqls {
    public static final String SELECT_BY_ID = "select id, file_name, save_file_name, content_type, delete_flag," +
            "create_date, modify_date from file_info where id=:id";

    public static final String UPDATE_BY_ID = "update file_info set file_name=:fileName, save_file_name=:saveFileName," +
            "content_type=:contentType, delete_flag=:deleteFlag, modify_date=:modifyDate where id=:id";

    public static final String DELETE_BY_ID = "delete from file_info where id=:id";
}
