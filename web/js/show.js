function query(id) {
    location.href='doquery.jsp?id='+id+'&comm=query';
}
function del(id) {
    var flang=confirm("确定删除这条信息吗?");
    if(flang==true){
        location.href='dodel.jsp?id='+id;
    }
}
function update(id) {
    location.href='doquery.jsp?id='+id+'&comm=update';
}