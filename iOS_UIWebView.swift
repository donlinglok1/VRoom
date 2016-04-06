import UIKit

class VRoomControl: UIViewController {
    
    @IBOutlet weak var webView: UIWebView!
    
    override func viewDidLoad() {
        super.viewDidLoad();
    }
    
    override func viewWillAppear(animated: Bool) {
        var url = NSURL(string:"https://darkdusk.org/vroom/api/viewer.php?key=$YOUR_API_KEY&img=4.jpg");
        self.webView!.loadRequest(NSURLRequest(URL:url!));
    }
}
