We utilize a 3-tier architecture with Persistence, Buisiness and Presentation layers.

Persistence has RoutinePersistence and WorkoutPersistence Interfaces. 
RoutinePersistence is implemented with RoutinePersistenceStub and RoutinePersistenceHSQLDB via dependency injection.
WorkoutPersistence is implemented with WorkoutPersistenceStub and WorkoutPersistenceHSQLDB via dependency injection. 
UpdateProgressPersistence is implemented with UpdateProgressPersistenceStubs and UpdateProgressPersistenceHSQLDB via dependency injection.

Buisiness has AccessRoutines, AccessWorkouts, AccessUpdate and Statistics classes.

Presentation has AddRoutineActivity, GraphActivity, HomeActivity, MyRoutineActivity, StartWorkoutActivity, StatisticsActivity, ProgressActivity, UploadProgressActivity classes.

Each of these layers is contained in its own package.

We also have a package called objects for domain-specific objects. These include Exercise, ExerciseList, Routine, Workout and Update.

We included an image of our architecture in file "ArchitectureIter2.jpg"
We included an image of our architecture for interation 3 in file "ARCHITECHTURE_3.jpg"