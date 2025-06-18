package com.example.jobapp.dtos.responses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResponseLoginDTO {
    @Schema(description = "Message")
    private String message;

    @Schema(description = "Token")
    private String token;
}
