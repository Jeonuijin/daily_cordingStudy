
    function compute(opt) {
        console.log("this : " + this); //일반 function에서의 this는 winsdow객체
        console.log("opt.id : " + opt.id);
        
        let totalTag = document.getElementById("total");
        let totalValue = parseInt(totalTag.value);
        
        let optValue = parseInt(opt.value);
        if (opt.checked) {  //옵션금액 더하기
            totalValue += optValue;
        }else { //옵션금액 빼기
            totalValue -= optValue;
        }
        console.log("totalValue : " + totalValue);
        //화면에 표시
        totalTag.value = totalValue;
    }