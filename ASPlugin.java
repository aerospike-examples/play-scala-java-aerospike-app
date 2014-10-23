package plugins;

import play.Application;
import play.Configuration;
import play.Logger;
import play.Plugin;
import play.api.Play;
import com.aerospike.client.*;

public class ASPlugin extends Plugin
{
  private final Application application;
  private static AerospikeClient ASClient; 

  public ASPlugin(Application application)
  {
    this.application = application;
  }

  @Override
  public void onStart()
  {
    Configuration configuration = application.configuration();

    //  Read Aerospike cluster config parameters from application.conf 
    String asClusterIP = configuration.getString("aerospike.cluster.ip");
    int asClusterPort = Integer.parseInt(configuration.getString("aerospike.cluster.port"));

    try 
    {
      //  Establish Aerospike cluster connection
      ASClient = new AerospikeClient(asClusterIP, asClusterPort);
      Logger.debug("Connection to Aerospike cluster established!");
    } catch (AerospikeException e) {
      Logger.debug("Connection to Aerospike cluster failed!");
      Logger.debug("AerospikeException: " + e.toString());
    } catch (Exception e) {
      Logger.debug("Connection to Aerospike cluster failed!");
      Logger.debug("Exception: " + e.toString());
    }

    Logger.info("ASPlugin started");
  }

  @Override
  public void onStop()
  {
    if (ASClient != null && ASClient.isConnected()) {
      //  Close Aerospike cluster connection
      Logger.debug("Connection to Aerospike cluster closed!");
      ASClient.close();
    }
    Logger.info("ASPlugin stopped");
  }

  public static AerospikeClient getASClient() {
    return ASClient;
  }
}
