/**
 * 将数组对象转为Json字符串，即将$("#form-test").serializeArray()的内容转为json字符串
 * @param formArray即 $("#form-test").serializeArray()，为json数组
 * @returns {string} json字符串
 */
function formToJson(formArray){
    var formObject = {};
    formArray.forEach(function (item) {
        formObject[item.name] = item.value;
    });
    return JSON.stringify(formObject);
}