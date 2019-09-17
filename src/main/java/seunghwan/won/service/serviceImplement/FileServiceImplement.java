package seunghwan.won.service.serviceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seunghwan.won.dao.FileInfoDao;
import seunghwan.won.dto.FileInfo;
import seunghwan.won.service.FileService;

import java.util.Calendar;

@Service
public class FileServiceImplement implements FileService {
    private final String CONTENT_TYPE = "image/png";
    private final int UN_DELETE_FLAG = 0;
    private final int DELETE_FLAG = 1;

    @Autowired
    FileInfoDao fileInfoDao;

    @Override
    public int save(String fileName, String filePath) {
        Calendar time = Calendar.getInstance();
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFileName(fileName);
        fileInfo.setSaveFileName(filePath);
        fileInfo.setContentType(CONTENT_TYPE);
        fileInfo.setDeleteFlag(UN_DELETE_FLAG);
        fileInfo.setCreateDate(time.getTime());
        fileInfo.setModifyDate(time.getTime());
        return  fileInfoDao.insertFileInfoImage(fileInfo);
    }
}
