package com.co.ias.Handyman.commons;

import java.sql.SQLException;

public interface UseCase <Input, Output>{

    Output execute(Input input) throws SQLException;

}
