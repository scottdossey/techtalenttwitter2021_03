package com.tts.TechTalentTwitter.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//NO ENTITY TAG--we are not storing TweetDisplay in database!!
public class TweetDisplay
{
    private User user;
    private String message;
    private String date; //THis is a string though--it will be a formatted date.
    private List<Tag> tags;
}
