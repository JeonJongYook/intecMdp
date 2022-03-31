package com.webmister.semicolon.repository;

import com.webmister.semicolon.domain.Report;
import com.webmister.semicolon.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    boolean existsByUserEmail(String Email);

    boolean existsByUserNickName(String name);

    Optional<UserInfo> findByUserEmailAndPassword(String email, String password);

    Optional<UserInfo> findByUserEmail(String email);

    Optional<UserInfo> findByPassword(String password);

    List<Report> findAllByReportList(Optional<UserInfo> id);

}