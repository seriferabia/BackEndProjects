package at.nacs.barista.logic;

public class BaristaWithThread {

//  private ThreadPoolExecutor executor =
//      (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
//
//  public void prepare(Beverage beverage) throws ExecutionException, InterruptedException {
//    List<Future<Boolean>> results = new ArrayList<>();
//    Future<Boolean> status = executor.submit(status());
//    Future<Boolean> preparation = executor.submit(preparation());
//    for (Future<Boolean> result : results) {
//      try{
//        System.out.println(result.get());
//      }catch (InterruptedException | ExecutionException e)
//      {
//        e.printStackTrace();
//      }
//    }
//
//  }


//  private final PickupClient pickupClient;
//  private ExecutorService executor =
//      new ThreadPoolExecutor(2,
//          2,
//          20000L, TimeUnit.MILLISECONDS,
//          new LinkedBlockingQueue<Runnable>());
//
//  public Boolean prepare(Beverage beverage) {
//    runTheProcesses(beverage);
//    return true;
//  }
//
//  private void runTheProcesses(Beverage beverage) {
//    Runnable dispatchTheOrder = pickupClient.receiveBeverage(beverage);
//    Runnable  timeTakesToMakeTheOrder = () -> {
//      try {
//        TimeUnit.MILLISECONDS.sleep(15000);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//    };
//    executor.submit(timeTakesToMakeTheOrder,dispatchTheOrder);
//  }


//  private ExecutorService executor = Executors.newSingleThreadExecutor();
//
//
//  public Boolean prepare(Beverage beverage) throws InterruptedException, ExecutionException, TimeoutException {
//    return executor.submit(getCallable()).get(15, TimeUnit.SECONDS);
//  }
//
//  private Callable<Boolean> preparation() {
//    return new Callable<Boolean>() {
//      @Override
//      public Boolean call() {
//        try {
//          Thread.sleep(15000);
//        } catch (InterruptedException e) {
//          System.out.println("Epic fail.");
//        }
//        executor.shutdownNow();
//        return true;
//      }
//    };
//  }
//
//  private Callable<Boolean> status() {
//    return new Callable<Boolean>() {
//      @Override
//      public Boolean call() {
//        return true;
//      }
//    };
//  }



//  public boolean prepare(Beverage beverage) {
//    try {
//      Thread.sleep(15000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    Beverage preparedBeverage = Beverage.builder()
//                                        .name(beverage.getName())
//                                        .ticketId(beverage.getTicketId())
//                                        .isReady(true)
//                                        .build();
//    return preparedBeverage.isReady();
//  }
//



//  public boolean prepare(Beverage beverage) {
//
//    ExecutorService executor = Executors.newSingleThreadExecutor();
//    Future<String> future = executor.submit(new Task());
//
//    try {
//      System.out.println("Started..");
//      System.out.println(future.get(15, TimeUnit.SECONDS));
//      System.out.println("Finished!");
//    } catch (TimeoutException | ExecutionException e) {
//      future.cancel(true);
//      System.out.println("Terminated!");
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//
//    executor.shutdownNow();
//    return true;
//  }
//
//
//  class Task implements Callable<String> {
//    @Override
//    public String call() throws Exception {
//      Thread.sleep(15000); // Just to demo a long running task of 4 seconds.
//      return "Ready!";
//    }
//  }
}
