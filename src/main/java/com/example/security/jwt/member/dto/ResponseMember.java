package com.example.security.jwt.member.dto;

import com.example.security.jwt.account.domain.Account;
import lombok.Builder;

import java.util.Set;
import java.util.stream.Collectors;

public record ResponseMember() {
    @Builder
    public record Info(
            String username,
            String password,
            String memberStatus,
            String memberType,
            Long tokenWeight,
            Set<String> authoritySet
    ) {

        public static ResponseMember.Info of(Account account) {
            if(account == null) return null;

            return Info.builder()
                    .username(account.getUsername())
                    .password(account.getPassword())
                    .memberStatus(account.getMemberStatus())
                    .memberType(account.getMemberType())
                    .tokenWeight(account.getTokenWeight())
                    .authoritySet(account.getAuthorities().stream()
                            .map(authority -> authority.getAuthorityName())
                            .collect(Collectors.toSet()))
                    .build();
        }
    }
}
