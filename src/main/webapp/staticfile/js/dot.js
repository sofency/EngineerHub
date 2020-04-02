$(document).ready(function () {
        const ulObj = $(".news").offset();
        console.log(ulObj);
        console.log()
        var ulObjHeight = $(".news")[0].offsetHeight;
        console.log( ulObjHeight)
        var  xPos = ulObj.left;//x的坐标
        var yPos = ulObj.top;//y的坐标
        console.log(xPos+":"+yPos)
        const dot = document.createElement("span");
        dot.className="rollDot";
        $(dot).css({
            "width":"8px",
            "height":"8px",
            "border-radius":"50%",
            "background-color":"red",
            "position": "absolute",
            "top":yPos-4,
            "left":xPos-4
        });
        document.body.appendChild(dot);
        var newHeight = ulObjHeight+yPos;
        circle(newHeight,yPos);
    });

function circle(ulObjHeight,yPos) {
    let flag = 0;
    setInterval(function () {
        if(flag==0){
            $(".rollDot").animate({
                top:ulObjHeight,
            },3000)
            flag=1;
        }else{
            $(".rollDot").animate({
                top:yPos-4,
            },3000);
            flag=0;
        }
    },3000);
}