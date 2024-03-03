package com.chatmee.chatmee.domains.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FindPeopleRequest {

    private int pageSize;
    private int pageNumber;
}
