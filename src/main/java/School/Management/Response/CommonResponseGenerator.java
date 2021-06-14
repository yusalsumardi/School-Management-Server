package School.Management.Response;

import org.springframework.stereotype.Component;

@Component
public class CommonResponseGenerator<T> {
    public <T> CommonResponse<T> successResponse(T datas, String message){
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setStatus("200");
        commonResponse.setMessage(message);
        commonResponse.setDatas(datas);

        return commonResponse;
    }

    public <T> CommonResponse<T> failedResponse(String message){
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setStatus("500");
        commonResponse.setMessage(message);

        return commonResponse;
    }

    public <T> CommonResponse<T> dataIsNull(String data){
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setStatus("400");
        commonResponse.setMessage(data + " Is Not Found");
        return commonResponse;
    }
}
