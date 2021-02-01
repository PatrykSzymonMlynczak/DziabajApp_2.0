(function () {

function showAlert() {
    alert("The button was clicked!")
}

function signIn(){

  $.ajax({
        type: 'GET',
        url: '/getToken'
    }).done(token => {
        console.log(JSON.stringify(token))
        console.log(token)
        updateHeadersWithToken(token)
    }).fail(error => {
        alert("Error : " + JSON.stringify(error))
    })
}

function updateHeadersWithToken(token){
$.ajaxSetup({
    headers: { 'Authorization': token }
});

}

$(() => {
    $("form").on('submit', e => {
        e.preventDefault()
    })
	$("#button").click(showAlert)
	$("#loginButton").click(signIn)
})

})()

