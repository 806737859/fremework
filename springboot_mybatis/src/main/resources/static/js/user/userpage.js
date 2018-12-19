function getUserInfo(userId){
    $.ajax({
        url: "/api/user/get/" + userId,
        type: "GET",
        dataType:"JSON",
        success: function (data) {
            console.log(data);
        }
    })
}