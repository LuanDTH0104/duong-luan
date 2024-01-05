package com.org.clockshop.repository;

import com.org.clockshop.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
//    @Query("SELECT R.roleId, R.roleName FROM Role R JOIN UserRole UR ON R.roleId = UR.roleId JOIN User U ON UR.userId = U.userId WHERE U.userAccount = :userAccount")
//    List<Role> getRoleByUserAccount(@Param("userAccount") String userAccount);

    @Query(value = "SELECT R.role_id, R.role_name FROM Role R JOIN user_role UR ON R.role_id = UR.role_id JOIN [user] U ON UR.user_id = U.user_id WHERE U.user_account = :userAccount",nativeQuery = true)
    List<Role> getRoleByUserAccount(@Param("userAccount") String userAccount);

}
