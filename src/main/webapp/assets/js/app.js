window.onload = () => {
  const offersLinks = document.querySelectorAll('.offers-table tbody tr')
  offersLinks.forEach(function(link){
    link.addEventListener('click', function(){
      window.location = this.getAttribute("data-link")
    })
  })
}