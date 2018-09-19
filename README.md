<img src="https://storage.googleapis.com/static.cubedpay.com/cubedpay_github_logo.png" align="right" />

# CubedPay Java
Java client for the CubedPay API.

The client is separated into 2 modules, the main java library and a bukkit plugin.

## Getting Your Keys
It's easy to get the keys you need:

1. Sign into http://app.cubedpay.com with your CubedPay account.
2. Visit the store you want to make purchases through
3. On the store navigation, select "Settings" then "Integrations".
4. Copy your Client ID and Secret. These will be your authentication methods.

### Using a Bot User (Coming Soon)
If you'd like to limit what access the client has to your store, use a Bot User instead.

1. Sign into http://app.cubedpay.com with your CubedPay account.
2. Visit the store you want to make purchases through
3. On the store navigation, select "Settings" then "Team".
4. Create a New Bot User with the permissions you'd like to allow.
5. Copy your bot's Bot ID and Secret. Use these in place of the regular App ID and Secret.

Please remember that using Bot Users requires your store to be on the **Unlimited** plan.

## API
### Standalone API
You can find the main standalone java library code in the `common` folder.

To get started with the API you need to create an instance of `CubedPayAPI` by calling 
`CubedPayAPI.create(String appID, String token)`.

To listen to store events you can call `CubedPayAPI#startEvents(String shopId)` and register listeners using
`CubedPayAPI#registerListener(Object listener)`. Events will called with methods that conform to the following format:
```java
public class Test {
    @CubedEventHandler
    public void onTransactionCompleted(TransactionCompletedEvent event) {
        //Your code here...
    }
}
```

#### Requesting a payment from a player.
```java
package test;

import co.melondev.cubedpay.CubedPayAPI;
import co.melondev.cubedpay.data.Item;

public class PaymentRequest {
    
    public static void main(String[] args){
      CubedPayAPI cubedpay = new CubedPayAPI("app_XXXXXXXXXXXXX", "oauth_XXXXXXXXXXXX");
      cubedpay.getShopAPI().getPackages(shopID, 1, 10)
                      .thenCompose(packages -> api.getShopAPI().createTransaction(shopID, "user@user.com",
                              "profile", new Item(packages.getData().get(0).getId(), 1)))
                      .thenAccept(transaction -> System.out.println("Payment Url: https://app.cubedpay.com/checkout/" + transaction.getId()))
                      .exceptionally(throwable -> {
                          throwable.printStackTrace();
                          return null;
                      });
      cubedpay.shutdown();
    }
    
}
```

#### Error Handling
API errors happen, even though we try to avoid them! (Although it could be your fault too... nobody is pointing fingers, though.)

To handle things that go badly:
```java
.exceptionally(throwable -> {
    throwable.printStackTrace();
    return null;
});
```

Easy!

### Minecraft: Java Edition Plugins
We currently support three of the most commonly-used Minecraft: Java Edition server software available: Bukkit/Spigot, BungeeCord, and Sponge. You can find the code for each of these plugins in their respective modules.

Our plugins will create a config on start that you need to fill in with your credentials from the panel. Every 
store that you add to the config will auto start the event system so all your need to do in your other plugins is 
register your event listeners.

You can get the API instance used by the plugin by calling `CubedPayPlugin.getAPI()`.

## Support
For any issues relating to the code, please create an issue. For any other help with the website/dashboard/purchases 
please [contact our support](https://cubedpay.com/support)
