import UIKit

class VRoomControl: UIViewController {
    
    @IBOutlet weak var webView: UIWebView!
    
    override func viewDidLoad() {
        super.viewDidLoad();
    }
    
    override func viewWillAppear(animated: Bool) {
	    //basic mode with server demo image
        var url = NSURL(string:"https://darkdusk.org/vroom/api/viewer.php?key=/*YOUR API KEY*/&img=/*YOUR IMG PATH*/");
        self.webView!.loadRequest(NSURLRequest(URL:url!));
        
	    //AR mode, please use mobile device testing
        var url = NSURL(string:"https://darkdusk.org/vroom/api/viewer.php?key=/*YOUR API KEY*/&img=/*YOUR IMG PATH*/&mo=AR");
        self.webView!.loadRequest(NSURLRequest(URL:url!));
        
	    //VR mode, please use mobile device testing
	    //You can use full path to load image, but make sure it fit "Cross-Origin Resource Sharing policy"
        var url = NSURL(string:"https://darkdusk.org/vroom/api/viewer.php?key=/*YOUR API KEY*/&img=/*YOUR IMG PATH*/&mo=VR");
        self.webView!.loadRequest(NSURLRequest(URL:url!));
    }
}
