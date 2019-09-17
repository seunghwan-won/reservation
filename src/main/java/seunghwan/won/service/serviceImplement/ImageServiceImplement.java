package seunghwan.won.service.serviceImplement;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seunghwan.won.dao.DisplayInfoImageDao;
import seunghwan.won.dao.ReservationIUserCommentImageDao;
import seunghwan.won.service.ImageService;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ImageServiceImplement implements ImageService {
    @Autowired
    DisplayInfoImageDao displayInfoImageDao;

    @Autowired
    ReservationIUserCommentImageDao reservationIUserCommentImageDao;

    @Override
    public byte[] getMapImage(int displayInfoId, HttpServletRequest request) {
        String path = displayInfoImageDao.getMapImagePath(displayInfoId);
        return getBytes(request, path);
    }

    @Override
    public byte[] getDisplayImage(int displayInfoId, HttpServletRequest request) {
        String path = displayInfoImageDao.getDisplayImagePath(displayInfoId);
        return getBytes(request, path);
    }

    @Override
    public byte[] getCommentThumbnailImage(int commentImageId, HttpServletRequest request) {
        String path;
        if (commentImageId > 2) {
            path = reservationIUserCommentImageDao.getCommentThumbnailImagePath(commentImageId);
            return getBytes2(request, path);
        }
        path = reservationIUserCommentImageDao.getCommentThumbnailImagePath(commentImageId);
        return getBytes(request, path);
    }

    private byte[] getBytes2(HttpServletRequest request, String path) {

        InputStream imageStream = null;
        byte[] imageByteArray = null;
        try {
            imageStream = new FileInputStream(path);
            imageByteArray = IOUtils.toByteArray(imageStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                imageStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imageByteArray;
    }

    private byte[] getBytes(HttpServletRequest request, String url) {
        String imagePath = request.getServletContext().getRealPath("resource/" + url);

        InputStream imageStream = null;
        byte[] imageByteArray = null;
        try {
            imageStream = new FileInputStream(imagePath);
            imageByteArray = IOUtils.toByteArray(imageStream);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                imageStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imageByteArray;
    }
}
