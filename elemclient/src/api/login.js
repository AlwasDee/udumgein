import request from "@/utils/request";

export function loginEmail(data) {
    return request({
        url: '/login/email',
        method: 'post',
        data
    })
}

export function loginPwd(data) {
    return request({
        url: '/login/pwd',
        method: 'post',
        data
    })
}

export function sendCode(email) {
    return request({
        url: '/login/' + email,
        method: 'post'
    })
}