class AppUtils {

    static BASE_API_URL = 'http://localhost:8080/api'
    static BASE_PRODUCTS_API = this.BASE_API_URL + '/products'
    static BASE_BRANCHS_API = this.BASE_API_URL + '/branchs'
    static BASE_BANPRODUCT_API = this.BASE_API_URL + '/products/ban'
    static BASE_UNBANPRODUCT_API = this.BASE_API_URL + '/products/unBan'
    static showSuccess = (text) => {
        $.toast({
            heading: 'Success',
            text: text,
            showHideTransition: 'slide',
            icon: 'success',
            position: 'top-right',
        })
    }

    static showError = (text) => {
        $.toast({
            heading: 'Error',
            text: text,
            showHideTransition: 'fade',
            icon: 'error',
            position: 'top-right',
        })
    }
}