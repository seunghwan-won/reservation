package seunghwan.won.service;

import javax.servlet.http.HttpServletRequest;

public interface ImageService {
    byte[] getMapImage(int displayInfoId, HttpServletRequest request);

    byte[] getDisplayImage(int displayInfoId, HttpServletRequest request);
}
