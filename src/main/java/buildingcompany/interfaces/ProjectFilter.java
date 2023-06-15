package buildingcompany.interfaces;

import buildingcompany.Project;

@FunctionalInterface
public interface ProjectFilter {
           boolean test(Project project);

   }

