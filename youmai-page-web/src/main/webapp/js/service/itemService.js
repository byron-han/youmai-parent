app.service('itemService', function ($http) {
    this.saveCart = function (itemId, num) {
        alert(itemId+"==="+num);
        return $http.get('http://localhost:9107/cart/addGoodsToCartList.do?itemId=' + itemId + '&num=' + num);
    }
})