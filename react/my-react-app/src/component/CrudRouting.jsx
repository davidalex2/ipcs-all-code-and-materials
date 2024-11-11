import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import CallFunction from "./CRUDoperation";
import CallFunction2 from "./CRUDoperation2";

function MyCrudComponent(){
    const queryClient=new QueryClient();

    return(
         <>
         <QueryClientProvider client={queryClient}>
        {/* <CallFunction></CallFunction> */}
        <CallFunction2></CallFunction2>
    </QueryClientProvider>
         </>
    );
}

export default MyCrudComponent;