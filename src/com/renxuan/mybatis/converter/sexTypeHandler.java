package com.renxuan.mybatis.converter;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.renxuan.mybatis.entity.SEX;

import java.util.*;

/*
 * 
 * 或者实现org.apache.ibatis.type.TypeHandler类
 * 例如将java的boolean类型自动转换到db的int类型
 * 将java Boolean true类型转换为数据里面的1 false转换为数据库里面的0
 */
public class sexTypeHandler extends BaseTypeHandler<SEX> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SEX parameter, JdbcType jdbcType) throws SQLException {
        System.out.println(i+"="+ parameter+"="+jdbcType);
    	if (jdbcType == null) {
            ps.setInt(i, parameter.value());
        } else {
            // see r3589
            ps.setObject(i, parameter.value(), jdbcType.TYPE_CODE);
        }
    }

    @Override
    public SEX getNullableResult(ResultSet rs, String columnName) throws SQLException {
    	System.out.println("columnName="+ columnName);
    	return sex(rs.getInt(columnName));
    }

    @Override
    public SEX getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    	System.out.println("columnIndex="+ columnIndex);
    	return sex(rs.getInt(columnIndex));

    }

    @Override
    public SEX getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    	System.out.println("columnIndex="+ columnIndex);
    	return sex(cs.getInt(columnIndex));
    }

    private SEX sex(int value) {
        Class<SEX> genderTypeClass = SEX.class;
        return Arrays.stream(genderTypeClass.getEnumConstants())
                .filter(genderType -> genderType.value() == value)
                .findFirst().orElse(SEX.UNKNOWN);
    }
}



