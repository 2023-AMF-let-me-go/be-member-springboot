package com.example.security.jwt.member.dto;

import lombok.Builder;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RequestMember() {
    @Builder
    public record Register(
            @NotNull
            String email,

            @NotNull
            String password,

            @NotNull
            String username,

            @NotNull
            String phoneNo,

            String memberType,

            String memberStatus,
            String businessNo,

            String nickname,

            String creatDt,

            String modifyDt
    ) {
    }
}
