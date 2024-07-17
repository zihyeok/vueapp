package com.folder.app.mapper;

import com.folder.app.dto.UserDTO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;

import java.util.List;


@Mapper
public interface UserMapper {

    /**
     * 쿼리: 모든 사용자 정보를 조회합니다.
     * 조건: del이 false인 사용자만 조회합니다.
     * 결과: 조회된 사용자 정보를 List<UserDTO>로 반환합니다.
     */
    @Select("select no, name, email, pwd, gender, del, date_format(regDate, '%Y-%m-%d %T' ) as regDate from user3 where del = false order by no desc")
    public List<UserDTO> findAll();

    @Update("update user3 set name = #{name}, pwd = #{pwd}, gender = #{gender} where no = #{no}")
    public int editById(UserDTO uDto);

    @Update("update user3 set del = true where no = #{no}")
    public int delete(int no);

    @SelectKey(statementType = StatementType.PREPARED, statement = "select last_insert_id() as no", keyProperty = "no", before = false, resultType = int.class)
    @Insert("insert into user3 (name, email, pwd, gender) values  (#{name},#{email},#{pwd},#{gender})")
    public int seve(UserDTO uDto);

    /**
     INSERT 문 코드 동작 - 새로운 사용자를 추가하고, 추가된 사용자의 번호를 반환합니다.

     statementType: StatementType.PREPARED - 준비된 문(statement)을 사용합니다.
     statement: "select last_insert_id() as no" - 방금 삽입된 레코드의 ID(기본 키 값)를 조회하는 SQL 문입니다. MySQL의 last_insert_id() 함수는 마지막으로 삽입된 레코드의 자동 증가 ID 값을 반환합니다.
     keyProperty: "no" - 조회된 값을 UserDTO 객체의 no 속성에 매핑합니다.
     before: false - INSERT 문이 실행된 후에 SELECT 문을 실행합니다.
     resultType: int.class - 결과 타입은 int입니다.
     */
}
