var blockUI = function (label, el) {
    el = el || $(".main-content");
    el.block({
            message: $("#progress-content").html().replace("{message}", label),
            onBlock: function () {
            },
            css: {
                width: '350px',
                top: '10px',
                left: '',
                right: '10px',
                border: 'none',
                padding: '5px',
                backgroundColor: '#000',
                '-webkit-border-radius': '10px',
                '-moz-border-radius': '10px',
                opacity: .6,
                color: '#fff'
            }
        }
    );
}

var unblockUI = function (el) {
    el = el || $(".main-content");
    el.unblock();
}


