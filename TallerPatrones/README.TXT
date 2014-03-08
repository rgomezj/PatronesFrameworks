1.El proyecto se ejecuta desde la clase pizzasApp ubicada en el paquete por defecto del proyecto (Default package).
2. Se realizan 3 llamados al metodo chargeOrder de RealBillingService, con 3 diferentes implementaciones de
CreditCardProcessor, todas ellas inyectadas via la anotación @Named desde el Configure del BillingModule