package seunghwan.won.dao.sqls;

public class DisplayInfoImageDaoSqls {
    public static final String SELECT_BY_ID = "select id, display_info_id, file_id from display_info_image where id=:id";

    public static final String DELETE_BY_ID = "delete from display_info_image where id=:id";

    public static final String SELECT_PATH_BY_ID = "SELECT f.save_file_name FROM display_info_image d INNER JOIN " +
            "file_info f on  f.id =d.file_id WHERE d.display_info_id =:id";
}
