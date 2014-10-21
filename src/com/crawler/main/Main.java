package com.crawler.main;

import com.crawler.settings.GeneralContents;


public class Main 
{
    public static void main(String[] args)
    {
        Logger logger = new Logger(GeneralContents.UserInfo.USERNAME, GeneralContents.UserInfo.PASSWORD);
        logger.loggin(GeneralContents.WebInfo.URL_LOGGIN);
        logger.getPicUrlList(GeneralContents.WebInfo.URL_PIC);
    }
}
