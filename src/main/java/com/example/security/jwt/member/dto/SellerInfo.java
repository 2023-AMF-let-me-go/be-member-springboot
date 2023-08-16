package com.example.security.jwt.member.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

public record SellerInfo() {
    @Builder
    public record Register(
            @NotNull
            String businessRgstNo,

            @NotNull
            String companyNm,

            @NotNull
            String companyContactInfo,

            @NotNull
            String companyEmail,

            @NotNull
            String companyAddr

    ) {
    }
}
