We utilize a 3-tier architecture with Persistence, Buisiness and Presentation layers.

Persistence has RoutinePersistence and WorkoutPersistence Interfaces. RoutinePersistence is implemented with RoutinePersistenceStub and RoutinePersistenceHSQLDB via dependency injection. WorkoutPersistence is implemented with WorkoutPersistenceStub and RoutinePersistenceHSQLDB via dependency injection.

Buisiness has AccessRoutines, AccessWorkouts, and Statistics classes.

Presentation has AddRoutineActivity, GraphActivity, HomeActivity, MyRoutineActivity, StartWorkoutActivity, StatisticsActivity classes.

Each of these layers is contained in its own package.

We also have a package called objects for domain-specific objects. These include Exercise, ExerciseList, Routine, and Workout.

We included an image of our architecture in file "ArchitectureIter2.jpg"
