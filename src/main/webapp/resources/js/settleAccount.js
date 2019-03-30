(function(w,d,u){
    var settleAccount = util.get('settleAccount');
    if(!settleAccount){
        return;
    }

    var $ = function(id){
        return document.getElementById(id);
    }

    window.onload = function(){
        $('newTable').onclick = function(e){
            var e = arguments[0] || window.event;
            target = e.srcElement ? e.srcElement : e.target;
            if(target.nodeName == "SPAN" && target.className == "moreNum"){
                var num = target.parentElement.children[1].textContent;
                var id = target.parentElement.children[2].textContent;
                num ++;
                target.parentElement.children[1].textContent = num;

                var price = parseFloat(target.parentElement.parentElement.children[2].textContent);
                var totalPrice = parseFloat(target.parentElement.parentElement.children[3].textContent);
                target.parentElement.parentElement.children[3].textContent = totalPrice + price;
                // util.modifyOne(products,id,num);
            }else if(target.nodeName == "SPAN" && target.className == "lessNum"){
                var num = target.parentElement.children[1].textContent;
                var id = target.parentElement.children[2].textContent;
                num --;
                if(num < 0){
                    alert("该商品数量为0");
                }else{
                    target.parentElement.children[1].textContent = num;

                    var price = parseFloat(target.parentElement.parentElement.children[2].textContent);
                    var totalPrice = parseFloat(target.parentElement.parentElement.children[3].textContent);
                    target.parentElement.parentElement.children[3].textContent = totalPrice - price;
                    // util.modifyOne(products,id,num);
                }
            } else if(target.nodeName == "BUTTON" && target.value == "pay") {
                var orderId = parseInt(target.dataset.id);
                var amount = parseInt(target.parentElement.parentElement.parentElement.children[1].children[1].textContent);
                ajax({
                    url:'/api/order/payOrder',
                    data:{id:orderId, amount:amount},
                    success:function(json){
                        var item = util.get('order-'+orderId);
                        if(item && item.parentNode){
                            item.parentNode.removeChild(item);
                        }
                        alert('购买成功');
                    }.bind(this)
                });
            } else if(target.nodeName == "BUTTON" && target.value == "cancle") {
                var orderId = parseInt(target.dataset.id);
                var amount = parseInt(target.parentElement.parentElement.parentElement.children[1].children[1].textContent);
                ajax({
                    url:'/api/order/cancleOrder',
                    data:{id:orderId, amount:amount},
                    success:function(json){
                        var item = util.get('order-'+orderId);
                        if(item && item.parentNode){
                            item.parentNode.removeChild(item);
                        }
                        alert('移除成功');
                    }.bind(this)
                });
            }
            return false;
        };
    };

    $('back').onclick = function(){
        window.history.back();
    }
})(window,document);