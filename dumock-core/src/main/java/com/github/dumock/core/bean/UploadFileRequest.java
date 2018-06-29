package com.github.dumock.core.bean;

import com.github.dumock.core.bean.parent.ActionRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jetty on 18/6/29.
 */
@ToString
@AllArgsConstructor
@Data
public class UploadFileRequest extends ActionRequest{

   private MultipartFile file;


}
