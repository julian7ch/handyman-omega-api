package com.co.ias.Handyman.commons;

public interface UseCase <Input, Output>{

    Output execute(Input input);

}
