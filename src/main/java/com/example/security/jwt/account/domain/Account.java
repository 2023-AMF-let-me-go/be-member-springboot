package com.example.security.jwt.account.domain;

import lombok.*;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "account")
@Getter
@NoArgsConstructor
public class Account {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 50, unique = true)
    private String username;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "token_weight")
    private Long tokenWeight; // 리프레시 토큰 가중치, // 리프레시 토큰 안에 기입된 가중치가 tokenWeight 보다 작을경우 해당 토큰은 유효하지않음

    @Column(name = "member_status")
    private String memberStatus;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "member_type")
    private String memberType;

    @Column(name = "business_no")
    private String businessNo;

    @Column(name = "activated")
    private boolean activated;

    @ManyToMany
    @JoinTable( // JoinTable은 테이블과 테이블 사이에 별도의 조인 테이블을 만들어 양 테이블간의 연관관계를 설정 하는 방법
            name = "account_authority",
            joinColumns = {@JoinColumn(name = "account_id", referencedColumnName = "account_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "authority_name")})
    private Set<Authority> authorities;

    @Builder
    public Account(String username, String password, String nickname, String memberStatus, String memberType, String businessNo, Set<Authority> authorities, boolean activated) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.memberStatus = memberStatus;
        this.memberType = memberType;
        this.businessNo = businessNo;
        this.authorities = authorities;
        this.activated = activated;
        this.tokenWeight = 1L; // 초기 가중치는 1
    }

    public void increaseTokenWeight() {
        this.tokenWeight++;
    }
}
