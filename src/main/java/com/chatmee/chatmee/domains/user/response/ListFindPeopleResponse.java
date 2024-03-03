package com.chatmee.chatmee.domains.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListFindPeopleResponse {

    private Long totalElements;
    private List<FindPeopleResponse> users;
}
