   package com.sohoenwa.databasecrud;;

    import java.util.ArrayList;
    import java.util.HashSet;
    import java.util.List;
    import java.util.Set;
    import java.util.concurrent.*;
    /**
     * Created by Shiva on 15/09/09.
     */
    public class MultipleMovieList
    {
        public List<Movie> Start(List<String>ImdbIdList) throws Exception
        {
            List<Movie> movieList=new ArrayList<Movie>();

            ExecutorService service = Executors.newCachedThreadPool();
            Set <Callable<Movie>> callables = new HashSet <Callable<Movie>> ();


            for (final String ImdbId:ImdbIdList) {
                callables.add(new Callable<Movie>() {
                    @Override
                    public Movie call() throws Exception {
                        Movie movie;
                        movie = new Movie(ImdbId);
                        return movie;
                    }
                });
            }

            try
            {
                List<Future<Movie>> FutureMoviesList = service.invokeAll(callables);
                for (Future<Movie> FutureMovieInstance : FutureMoviesList)
                {
                    movieList.add(FutureMovieInstance.get());
                    //System.out.println (FutureMovieInstance.get().title);
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            catch (ExecutionException e)
            {
                e.printStackTrace();
            }
            return movieList;
        }
    }
