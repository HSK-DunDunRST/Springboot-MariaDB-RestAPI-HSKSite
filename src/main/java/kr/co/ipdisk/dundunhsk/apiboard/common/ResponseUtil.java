package kr.co.ipdisk.dundunhsk.apiboard.common;

import kr.co.ipdisk.dundunhsk.apiboard.data.dtoSet.ApiResponseDTO;

public class ResponseUtil {

    public static <T> ApiResponseDTO<T> ok(T response){
        return ApiResponseDTO.<T>builder()
            .success(true)
            .data(response)
            .errorResponse(null)
            .build();
    }

    public static <T> ApiResponseDTO<T> error(ErrorResponse errorResponse){
        return ApiResponseDTO.<T>builder()
            .success(false)
            .data(null)
            .errorResponse(errorResponse)
            .build();
    }
}
