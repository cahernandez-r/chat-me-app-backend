package com.chatmee.chatmee.domains.user.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FetchInfoUserResponse {

    private Long id;
    private String userName;
    private String securityWord;
}
